package org.example;

import graphicalUserInterface.Controller;
import graphicalUserInterface.View;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


        View view = new View();
        Controller controller = new Controller(view);
    }
}
