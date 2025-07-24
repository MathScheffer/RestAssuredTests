
import DTOs.Localizacao;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class Teste {
    @BeforeTest
    public void setup(){
        baseURI = "http://localhost";
        RestAssured.port = 3000;
        basePath = "/api";
    }

    @Test(groups = "negativos")
    public void getAtivoInexistente(){
        given()
                .pathParam("id", 8)
                .when()
                .get("/ativos/{id}")
                .then()
                .statusCode(404);
    }

    @Test(groups = "negativo")
    public void postLocalizacoesTagsInexistentes(){
        Localizacao localizacao = Localizacao.builder()
                .tag_ativo("teste blabal")
                .tag_local("ao ao ao")
                .build();

        given()
                .contentType(ContentType.JSON)
                .body(localizacao)
                .when()
                .post("/localizacao")
                .then()
                .statusCode(422);
    }
    //@TODO adicionar verificação do BODY
    @Test(groups = "positivos")
    public void postSucess(){
        Localizacao localizacao = Localizacao.builder()
                .tag_ativo("xpto")
                .tag_local("local1")
                .build();

        given()
                .contentType(ContentType.JSON)
                .body(localizacao)
                .when()
                .post("/localizacao")
                .then()
                .statusCode(201);

    }


}
