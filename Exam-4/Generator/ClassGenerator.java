// Mindaugas Sharskus
// 20/04/2017

public class ClassGenerator{
    // http://stackoverflow.com/questions/4645020/when-to-use-stringbuilder-in-java
    private String _class;
    private String[][] variables;
    private int t = 4;    // tab length in spaces

    public ClassGenerator(String className, String... fields){  // "Country", {"int:countryId", "String:countryName"}
        createVariables(fields);
        _class = String.format("%npublic class "+ className +"{%n"
                + tab(t) +"// Fields%n"
                + add_Fields()
                +"%n"+ tab(t) +"// Constructors%n"
                + add_Constructors(className)
                +"%n"+ tab(t) +"// Setters & Getters%n"
                + add_SettersGetters(className)
                + add_toString(className)
                +"}");
    }

    private String add_toString(String className){
        java.util.StringJoiner sj = new java.util.StringJoiner(
                " +\" \"+ ",

                 (tab(t) +"@Override%n"
                + tab(t) +"public String toString(){%n"
                + tab(t *2) + "return \""+ className +": \"+ "),

                  ";%n"
                + tab(t) +"}%n");

        for(String[] variable : variables){
            sj.add("get"+ capitalize(variable[1]) +"()");
        }
        return sj.toString();
    }

    private String add_SettersGetters(String className){
        // Full param setter
        StringBuilder sb = new StringBuilder();
        sb.append("%n"+ tab(t) +"// Full parameter setter%n");
        java.util.StringJoiner head = new java.util.StringJoiner(", ", (tab(t) +"public void set"+ className +"("), "){%n");

        for(String[] variable : variables)
            head.add(variable[0] +" "+ variable[1]);

        sb.append(head.toString());

        for(String[] variable : variables)
            sb.append(tab(t *2) +"set"+ capitalize(variable[1]) +"("+ variable[1] +");%n");

        sb.append(tab(t) +"}%n");

        //other
        sb.append("%n"+ tab(t) +"// Setters & Getters%n");

        for(String[] variable : variables){
            // setters
            sb.append(tab(t) +"public void set"+ capitalize(variable[1]) +"("+ variable[0] +" "+ variable[1] +"){%n");
            sb.append(tab(t *2) +"this."+ variable[1] +" = "+ variable[1] +";%n");
            sb.append(tab(t) +"}%n");
            // Getters
            sb.append(tab(t) +"public "+ variable[0] +" get"+ capitalize(variable[1]) +"(){%n");
            sb.append(tab(t *2) +"return "+ variable[1] +";%n");
            sb.append(tab(t) +"}%n");
            sb.append("%n");
        }
        return sb.toString();
    }

    private String add_Constructors(String className){
        StringBuilder sb = new StringBuilder();
        java.util.StringJoiner sj = new java.util.StringJoiner(", ", (tab(t) +"public "+ className +"("), "){%n");

        for(String[] variable : variables)
            sj.add(variable[0] +" "+ variable[1]);

        sb.append(sj.toString());
        sj = new java.util.StringJoiner(", ", (tab(t *2) +"set"+ className +"("), ");%n");

        for(String[] variable : variables)
            sj.add(variable[1]);

        sb.append(sj.toString());
        sb.append(tab(t) +"}%n");

        // Default constructor
        sb.append(tab(t) +"public "+ className +"(){%n");
        sj = new java.util.StringJoiner(", ", tab(t *2) +"this(", ");%n");

        for(String[] variable : variables){
            if(variable[0].equals("int") || variable[0].equals("double"))
                sj.add("0");
            else if(variable[0].equals("String"))
                sj.add("\"no"+ variable[1] +"\"");
            else
                sj.add("\"no "+ variable[0] +":"+ variable[1] +"\"");
        }

        sb.append(sj.toString());
        sb.append("%n}%n");
        return sb.toString();
    }

    private String add_Fields(){  // {"int:countryId", "String:countryName"}
        StringBuilder sb = new StringBuilder();
        for(String[]sArr : variables){
            sb.append(tab(t) +"private "+  sArr[0] +" "+ sArr[1] +";%n");
        }
        return sb.toString();
    }

    private void createVariables(String... fields){
        String[][] sArr = new String[fields.length][2];

        for(int i = 0; i < sArr.length; i++){
            sArr[i] = fields[i].split(":");
        }
        this.variables = sArr;
    }

    private String capitalize(String s){
        return ""+ s.toUpperCase().charAt(0) + s.substring(1);
    }

    // Creates tab using spaces of length.
    private String tab(int length){
        return String.format("%"+ length +"s", " ");
    }

    @Override
    public String toString(){
        return _class;
    }
}
