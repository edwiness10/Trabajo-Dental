/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dent.dato;

/**
 *
 * @author Edwin
 */
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;




public class Pool {


    public DataSource dataSource;

    public String db = "fundacion";
    public String url = "jdbc:mysql://25.85.247.71:3306/"+db;
    public String user = "root";
    public String pass = "javac";



    public Pool(){

        inicializaDataSource();

    }



    private void inicializaDataSource(){


        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(pass);
        basicDataSource.setUrl(url);
        basicDataSource.setMaxActive(50);


        dataSource = basicDataSource;

    }



}