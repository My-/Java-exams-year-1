// Mndaugas Sharskus
// 20/04/2017

import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;

public class CreateClass{
    private static final String[] m = new String[]{
        // m[0]
        "Usage: CreateClass [-option] [<className> <classVariables[type:name]>]\n"+
        "Example: CreateClass Person  \"String:name int:age double:height\"\n"+
        "\tThis comand will create file Person.java with provided variables (constructor, setters, getters and toString method)",
        // m[1]
        "Wrong arguments! Type -? or -help for help"
    };

    public static void main(String[] args) {

        int arguments = args.length;


        switch(arguments){
            case 0:
                System.out.println(m[0]);
                break;
            case 1:
                option(args[0]);
                break;
            case 2:
                createClass(args);
                break;
            default:
                System.out.println(m[1]);
        }

    }// main()

    private static void createClass(String[] args){
        String className = args[0];
        String[] variables = args[1].split(" ");
        String fileName = className.trim() +".java";

        try(Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fileName), "utf-8"))){

            writer.write(new ClassGenerator(className, variables).toString());

        }catch(Exception e){
            System.err.println(e);
        }
    }

    private static void option(String option){
        if(option.charAt(0) != '-'){
            System.out.println(m[1]);
            return;
        }

        switch(option.substring(1).toLowerCase()){
            case "?":
            case "help":
                System.out.println(m[0]);
        }

    }// option()
}
