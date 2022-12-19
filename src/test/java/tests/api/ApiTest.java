package tests.api;

import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import configuration.ReadProperties;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import models.Project;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class ApiTest extends BaseApiTest {
    private int projectId;

    @Test
    public void getAllUsers() {

        given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password())
                .log().all()
                .when()
                .get(Endpoints.GET_All_USERS)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getUserNotExist() {
        JsonPath responseContent = given()
                .pathParam("user_id", 3)
                .when()
                .get(Endpoints.GET_USER)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract().jsonPath();

        Assert.assertEquals(responseContent.get("error"), "Field :user is not a valid user.");
    }

    @Test
    public void createProjectSuccessTest() throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/createProject.json"));
        Project project = new Gson().fromJson(reader, Project.class);
        JsonPath responseContent = given()
                .body(project, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.CREATE_PROJECT)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath();

        projectId = responseContent.get("id");

        Assert.assertEquals(responseContent.get("name"), project.getName());
        Assert.assertEquals(responseContent.get("announcement"), project.getAnnouncement());
        Assert.assertEquals((int) responseContent.get("suite_mode"), project.getType());
    }

    @Test(dependsOnMethods = "createProjectSuccessTest")
    public void getProjectSuccessTest() {
        given()
                .pathParam("project_id", projectId)
                .when()
                .get(Endpoints.GET_PROJECT)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getProjectNotExist() {
        JsonPath responseContent = given()
                .pathParam("project_id", 0)
                .when()
                .get(Endpoints.GET_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract().jsonPath();

        Assert.assertEquals(responseContent.get("error"), "Field :project_id is not a valid or accessible project.");
    }

    @Test//(dependsOnMethods = {"createProjectSuccessTest", "getProjectSuccessTest"})
    public void deleteProjectSuccessTest() {
        given()
                .pathParam("project_id", projectId)
                .when()
                .post(Endpoints.DELETE_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
