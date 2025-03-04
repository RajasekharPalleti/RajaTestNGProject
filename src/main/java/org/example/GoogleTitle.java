package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTitle{
    public static void main(String[] args){
        WebDriver wb = new ChromeDriver();
        wb.get("https://www.google.com");
        System.out.println(wb.getTitle());
        wb.quit();

    }
}