package edu.oru.cit352.oluaki870.mytriviaapp;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {

    private static List<QuestionsList> htmlQuestions() {
        final List<QuestionsList> questionsLists = new ArrayList<>();

        //Create object of QuestionsList class and pass a question along with options and answer
        //questions secured from: https://www.javatpoint.com/html-mcq
        final QuestionsList question1 = new QuestionsList("HTML stands for -","HighText Machine Language", "HyperText and links Markup Language","HyperText Markup Language","None of these","HyperText Markup Language","");
        final QuestionsList question2 = new QuestionsList("The correct sequence of HTML tags for starting a webpage is -","Head, Title, HTML, body", "HTML, Body, Title, Head","HTML, Head, Title, Body","HTML, Head, Title, Body","HTML, Head, Title, Body","");
        final QuestionsList question3 = new QuestionsList("Which of the following element is responsible for making the text bold in HTML?","<pre>", "<a>","<b>","<br>","<b>","");
        final QuestionsList question4 = new QuestionsList("Which of the following tag is used for inserting the largest heading in HTML?","<h3>", "<h1>","<h5>","<h6>","<h1>","");
        final QuestionsList question5 = new QuestionsList("Which of the following tag is used to insert a line-break in HTML?","<br>", "<a>","<pre>","<b>","<br>","");
        final QuestionsList question6 = new QuestionsList("How to create an unordered list (a list with the list items in bullets) in HTML?","<ul>", "<ol>","<li>","<i>","<ul>","");
        final QuestionsList question7 = new QuestionsList("Which character is used to represent the closing of a tag in HTML?","\\", "!","/",".","/","");
        final QuestionsList question8 = new QuestionsList("How to create a hyperlink in HTML?","<a href = \"www.javatpoint.com\"> javaTpoint.com </a>", "<a url = \"www.javatpoint.com\" javaTpoint.com /a>","<a link = \"www.javatpoint.com\"> javaTpoint.com </a>","<a> www.javatpoint.com <javaTpoint.com /a>","<a href = \"www.javatpoint.com\"> javaTpoint.com </a>","");
        final QuestionsList question9 = new QuestionsList("How to create an ordered list (a list with the list items in numbers) in HTML?","<ul>", "<ol>","<li>","<i>","<ol>","");
        final QuestionsList question10 = new QuestionsList("Which of the following element is responsible for making the text italic in HTML?","<i>", "<italic>","<it>","<pre>","<i>","");
        final QuestionsList question11 = new QuestionsList("How to insert an image in HTML?","<img href = \"jtp.png\" />", "<img url = \"jtp.png\" />","<img link = \"jtp.png\" />","<img src = \"jtp.png\" />","<img src = \"jtp.png\" />","");
        final QuestionsList question12 = new QuestionsList("How to add a background color in HTML?","<marquee bg color: \"red\">", "<marquee bg-color = \"red\">","<marquee bgcolor = \"red\">","<marquee color = \"red\">","<marquee bgcolor = \"red\">","");
        final QuestionsList question13 = new QuestionsList("<input> is -","a format tag.", "an empty tag.","All of the above","None of the above","an empty tag","");
        final QuestionsList question14 = new QuestionsList("Which of the following tag is used to make the underlined text?","<i>", "<ul>","<u>","<pre>","<u>","");
        final QuestionsList question15 = new QuestionsList("How to create a checkbox in HTML?","<input type = \"checkbox\">", "<input type = \"button\">","<checkbox>","<input type = \"check\">","<input type = \"checkbox\">","");

        // add all questions to List<QuestionsList>
        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);
        questionsLists.add(question7);
        questionsLists.add(question8);
        questionsLists.add(question9);
        questionsLists.add(question10);
        questionsLists.add(question11);
        questionsLists.add(question12);
        questionsLists.add(question13);
        questionsLists.add(question14);
        questionsLists.add(question15);

        return questionsLists;

    }

    private static List<QuestionsList> cssQuestions() {
        final List<QuestionsList> questionsLists = new ArrayList<>();

        //Create object of QuestionsList class and pass a question along with options and answer
        //questions secured from: https://www.javatpoint.com/css-mcq
        final QuestionsList question1 = new QuestionsList("CSS stands for -","Cascade style sheets", "Color and style sheets","Cascading style sheets","None of the above","Cascading style sheets","");
        final QuestionsList question2 = new QuestionsList("Which of the following is the correct syntax for referring the external style sheet?","<style src = example.css>", "<style src = \"example.css\" >","<stylesheet> example.css </stylesheet>","<link rel=\"stylesheet\" type=\"text/css\" href=\"example.css\">","<link rel=\"stylesheet\" type=\"text/css\" href=\"example.css\">","");
        final QuestionsList question3 = new QuestionsList("The property in CSS used to change the background color of an element is -","bgcolor", "color","background-color","All of the above","background-color","");
        final QuestionsList question4 = new QuestionsList("The property in CSS used to change the text color of an element is -","bgcolor", "color","background-color","All of the above","color","");
        final QuestionsList question5 = new QuestionsList("The CSS property used to control the element's font-size is -","text-style", "text-size","font-size","None of the above","font-size","");
        final QuestionsList question6 = new QuestionsList("The HTML attribute used to define the inline styles is -","style", "styles","class","None of the above","style","");
        final QuestionsList question7 = new QuestionsList("The HTML attribute used to define the internal stylesheet is -","<style>", "style","<link>","<script>","<style>","");
        final QuestionsList question8 = new QuestionsList("Which of the following CSS property is used to set the background image of an element?","background-attachment", "background-image","background-color","None of the above","background-image","");
        final QuestionsList question9 = new QuestionsList("Which of the following is the correct syntax to make the background-color of all paragraph elements to yellow?","p {background-color : yellow;}", "p {background-color : #yellow;}","all {background-color : yellow;}","all p {background-color : #yellow;}","p {background-color : yellow;}","");
        final QuestionsList question10 = new QuestionsList("Which of the following is the correct syntax to display the hyperlinks without any underline?","a {text-decoration : underline;}", "a {decoration : no-underline;}","a {text-decoration : none;}","None of the above","a {text-decoration : none;}","");
        final QuestionsList question11 = new QuestionsList("Which of the following property is used as the shorthand property for the padding properties?","padding-left", "padding-right","padding","All of the above","padding","");
        final QuestionsList question12 = new QuestionsList("The CSS property used to make the text bold is -","font-weight : bold", "weight: bold","font: bold","style: bold","font-weight : bold","");
        final QuestionsList question13 = new QuestionsList("Are the negative values allowed in padding property?","Yes", "No","Can't say","May be","No","");
        final QuestionsList question14 = new QuestionsList("Which of the following property is used as the shorthand property of margin properties?","margin-left", "margin-right","margin","None of the above","margin","");
        final QuestionsList question15 = new QuestionsList("The CSS property used to specify the transparency of an element is -","opacity", "filter","visibility","overlay","opacity","");

        // add all questions to List<QuestionsList>
        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);
        questionsLists.add(question7);
        questionsLists.add(question8);
        questionsLists.add(question9);
        questionsLists.add(question10);
        questionsLists.add(question11);
        questionsLists.add(question12);
        questionsLists.add(question13);
        questionsLists.add(question14);
        questionsLists.add(question15);

        return questionsLists;

    }

    private static List<QuestionsList> jsQuestions() {
        final List<QuestionsList> questionsLists = new ArrayList<>();

        //Create object of QuestionsList class and pass a question along with options and answer
        //questions secured from: https://www.javatpoint.com/javascript-mcq
        final QuestionsList question1 = new QuestionsList("What type of language is JavaScript ___","Object-Oriented", "Object-Based","Assembly-language","High-level","Object-Based","");
        final QuestionsList question2 = new QuestionsList("Which one of the following also known as Conditional Expression:","Alternative to if-else", "Switch statement","If-then-else statement","immediate if","immediate if","");
        final QuestionsList question3 = new QuestionsList("In JavaScript, what is a block of statement?","Conditional block", "block that combines a number of statements into a single compound statement","both conditional block and a single statement","block that contains a single statement","block that combines a number of statements into a single compound statement","");
        final QuestionsList question4 = new QuestionsList("When interpreter encounters an empty statements, what it will do:","Shows a warning", "Prompts to complete the statement","Throws an error","Ignores the statements","Ignores the statements","");
        final QuestionsList question5 = new QuestionsList("The \"function\" and \" var\" are known as:","Keywords", "Data types","Declaration statements","Prototypes","Declaration statements","");
        final QuestionsList question6 = new QuestionsList("Which of the following variables takes precedence over the others if the names are the same?","Global variable", "The local element","The two of the above","None of the above","The local element","");
        final QuestionsList question7 = new QuestionsList("Which one of the following is the correct way for calling the JavaScript code?","Preprocessor", "Triggering Event","RMI","Function/Method","Function/Method","");
        final QuestionsList question8 = new QuestionsList("Which of the following type of a variable is volatile?","Mutable variable", "Dynamic variable","Volatile variable","Immutable variable","Mutable variable","");
        final QuestionsList question9 = new QuestionsList("Which of the following option is used as hexadecimal literal beginning?","00", "0x","0X","Both 0x and 0X","Both 0x and 0X","");
        final QuestionsList question10 = new QuestionsList("When there is an indefinite or an infinite value during an arithmetic computation in a program, then JavaScript prints______.","Prints an exception error", "Prints an overflow error","Displays \"Infinity\"","Prints the value as such","Displays \"Infinity\"","");
        final QuestionsList question11 = new QuestionsList("In the JavaScript, which one of the following is not considered as an error:","Syntax error", "Missing of semicolons","Division by zero","Missing of Bracket","Division by zero","");
        final QuestionsList question12 = new QuestionsList("Which of the following given functions of the Number Object formats a number with a different number of digits to the right of the decimal?","toExponential()", "toFixed()","toPrecision()","toLocaleString()","toFixed()","");
        final QuestionsList question13 = new QuestionsList("Which of the following number object function returns the value of the number?","toString()", "valueOf()","toLocaleString()","toPrecision()","valueOf()","");
        final QuestionsList question14 = new QuestionsList("Which of the following function of the String object returns the character in the string starting at the specified position via the specified number of characters?","slice()", "split()","substr()","search()","substr()","");
        final QuestionsList question15 = new QuestionsList("In JavaScript the x===y statement implies that:","Both x and y are equal in value, type and reference address as well.", "Both are x and y are equal in value only.","Both are equal in the value and data type.","Both are not same at all.","Both are equal in the value and data type.","");

        // add all questions to List<QuestionsList>
        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);
        questionsLists.add(question7);
        questionsLists.add(question8);
        questionsLists.add(question9);
        questionsLists.add(question10);
        questionsLists.add(question11);
        questionsLists.add(question12);
        questionsLists.add(question13);
        questionsLists.add(question14);
        questionsLists.add(question15);

        return questionsLists;

    }

    private static List<QuestionsList> webDevQuestions() {
        final List<QuestionsList> questionsLists = new ArrayList<>();

        //Create object of QuestionsList class and pass a question along with options and answer
        //questions secured from: https://meritnotes.com/computer-quiz/web-design-mcq/1-6860/ and https://electronicspost.com/multiple-choice-questions-and-answers-on-web-design/
        final QuestionsList question1 = new QuestionsList("Web page editors works on a ____ principle.","WWW", "HTML","WYSIWYG","WYGWYSI","WYSIWYG","");
        final QuestionsList question2 = new QuestionsList("Which program is used by web clients to view the web pages?","Web browser", "Protocol","Web server","Search Engine","Web browser","");
        final QuestionsList question3 = new QuestionsList("What is the name of the location address of the hypertext documents?","Uniform Resource Locator", "Web server","File","Web address","Uniform Resource Locator","");
        final QuestionsList question4 = new QuestionsList("What are shared on the Internet and are called as Web pages?","Programs", "Cables","Hypertext documents","None","Hypertext documents","");
        final QuestionsList question5 = new QuestionsList("How many colour names are used by the browsers?","8", "10","12","16","16","");
        final QuestionsList question6 = new QuestionsList("Which tag is used to display text in title bar of a web document?","Body tag", "Meta tag","Title tag","Comment tag","Title tag","");
        final QuestionsList question7 = new QuestionsList("The ____ attribute is used to identify the values of variables.","text", "http-equiv","content","name","content","");
        final QuestionsList question8 = new QuestionsList("The language that instructs the browser on how to display the hypertext, and adds pictures to the document is __","C", "COBOL","HTML","BASIC","HTML","");
        final QuestionsList question9 = new QuestionsList("Which tag is used to identify the keywords describing the site?","Comment tag", "Title tag","Meta tag","Anchor tag","Meta tag","");
        final QuestionsList question10 = new QuestionsList("Which are used with a tag to modify its function?","Files", "Functions","Attributes","Documents","Attributes","");
        final QuestionsList question11 = new QuestionsList("What is a CMS in web design","Content Management System", "Creative Management System","Content Mixing System","Creatives Managerial System","Content Management System","");
        final QuestionsList question12 = new QuestionsList("To make your website mobile friendly, you can make your website","Responsive", "Reactive","Fast Loading","Light","Responsive","");
        final QuestionsList question13 = new QuestionsList("Which of the following statements is false","You can make a website without using HTML", "You can make a website without using PHP","You can make a website without using CSS","You can make a website without using Javascript","You can make a website without using HTML","");
        final QuestionsList question14 = new QuestionsList("What is WordPress","It is a software used to press text", "It is a text formatting software","It is a CMS (Content Management System)","It is mail service","It is a CMS (Content Management System)","");
        final QuestionsList question15 = new QuestionsList("Which of the following is true about Javascript","It is a server side scripting language", "It is client side scripting language","It is a Software","It is a database","It is client side scripting language","");

        // add all questions to List<QuestionsList>
        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);
        questionsLists.add(question7);
        questionsLists.add(question8);
        questionsLists.add(question9);
        questionsLists.add(question10);
        questionsLists.add(question11);
        questionsLists.add(question12);
        questionsLists.add(question13);
        questionsLists.add(question14);
        questionsLists.add(question15);

        return questionsLists;

    }

    // depending on the topic selected return respective questionsList array
    public static List<QuestionsList> getQuestions(String selectedTopicName) {
        switch(selectedTopicName) {
            case "html":
                return htmlQuestions();
            case "css":
                return cssQuestions();
            case "js":
                return jsQuestions();
            default:
                return webDevQuestions();
        }
    }
}
