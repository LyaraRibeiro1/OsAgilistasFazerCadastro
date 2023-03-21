package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class RegisterTest {
    @Test public void testFazerLoginNoAgilistas() {
    /*
    Cenário: Verificar login com sucesso
    Dado que o usuário esteja na página “os agilistas”
    Quando o usuário realizar o login com sucesso
    Então a página deve redirecionar o usuário para sua página de perfil
    */

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nícholas\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        driver.get("https://osagilistas.com/");
        driver.findElement(By.linkText("Faça o login")).click();
        driver.findElement(By.name("text-1")).sendKeys("lyara.lrs@gmail.com");
        driver.findElement(By.name("password-1")).sendKeys("Thuco123*");
        driver.findElement(By.xpath("//*[@id=\"forminator-module-17221\"]/div[5]/div/div/button")).click();
        assertEquals("https://osagilistas.com/meu-perfil/",driver.getCurrentUrl());
        driver.quit();
    }
    @Test public void testEmailIncorreto(){
    /*
    Cenário: Verificar login com dados incorretos
    Dado que o usuário esteja na página “os agilistas”
    E o usuário insere um email incorreto
    E o usuário insere uma senha incorreta
    Quando o usuário clicar em login
    Então a página deve exibir uma mensagem de erro
    */

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nícholas\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        driver.get("https://osagilistas.com/");
        driver.findElement(By.linkText("Faça o login")).click();
        driver.findElement(By.name("text-1")).sendKeys("email@gmail.com");
        driver.findElement(By.name("password-1")).sendKeys("Password");
        driver.findElement(By.xpath("//*[@id=\"forminator-module-17221\"]/div[5]/div/div/button")).click();
        driver.findElement(By.linkText("Lost your password")).click();
        assertEquals("https://osagilistas.com/wp-login.php?action=lostpassword",driver.getCurrentUrl());
        driver.quit();
    }
    @Test public void testVerificarUsuarioLogado() {
    /*
    Cenário: Verificar página de login com usuário logado
    Dado que o usuário esteja logado na página “os agilistas”
    Quando o usuário acessar a página de login
    Então a página deve informar que o usuário já está logado
    */

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nícholas\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        driver.get("https://osagilistas.com/");
        driver.findElement(By.linkText("Faça o login")).click();
        driver.findElement(By.name("text-1")).sendKeys("lyara.lrs@gmail.com");
        driver.findElement(By.name("password-1")).sendKeys("Thuco123*");
        driver.findElement(By.xpath("//*[@id=\"forminator-module-17221\"]/div[5]/div/div/button")).click();
        driver.get("https://osagilistas.com/login/");
        String erro = driver.findElement(By.className("elementor-shortcode")).getText();
        assertEquals("Você já está logado. ", erro);
        driver.quit();
    }
    @Test public void testFazerLogoutNoAgilistas() {
    /*
    Cenário: Verificar logout com sucesso
    Dado que o usuário esteja logado na página “os agilistas”
    E o usuário clica em Logout
    Quando o usuário confirma que deseja se desconectar
    Então a página deve desconectar a conta
    E redirecionar para a página inicial
    */

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nícholas\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        driver.get("https://osagilistas.com/");
        driver.findElement(By.linkText("Faça o login")).click();
        driver.findElement(By.name("text-1")).sendKeys("lyara.lrs@gmail.com");
        driver.findElement(By.name("password-1")).sendKeys("Thuco123*");
        driver.findElement(By.xpath("//*[@id=\"forminator-module-17221\"]/div[5]/div/div/button")).click();
        driver.findElement(By.className("logout")).click();
        driver.findElement(By.linkText("desconectar")).click();
        String login = driver.findElement(By.xpath("/html/body/div[1]/div/header/div/div/div[3]/div/div/section/div/div/div/div/div/div/div/div/div/p/b[1]/a")).getText();
        assertEquals("Faça o login",login);
        driver.quit();
    }
}

