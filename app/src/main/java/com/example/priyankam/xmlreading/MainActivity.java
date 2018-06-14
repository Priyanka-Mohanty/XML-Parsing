package com.example.priyankam.xmlreading;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.textView1);

        try {
            InputStream is = getAssets().open("file.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            Element element = doc.getDocumentElement();
            element.normalize();

            System.out.println("Root element :" + element.getNodeName());

            NodeList nList = doc.getElementsByTagName("var");
            System.out.println("----------------------------");

            for (int i = 0; i < nList.getLength(); i++) {

                Node node = nList.item(i);
                System.out.println("\nCurrent Element :" + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;

                    System.out.println("var name : "
                            + eElement.getAttribute("name"));
                    System.out.println("value : "
                            + eElement.getAttribute("value"));
                    System.out.println("quality: "
                            + eElement.getAttribute("quality"));

                  /*  System.out.println("Salary : "
                            + eElement.getElementsByTagName("salary")
                            .item(0).getTextContent());*/

                    tv1.setText(tv1.getText() + "\nName : " + eElement.getAttribute("name") + "\n");
                    tv1.setText(tv1.getText() + "value : " + eElement.getAttribute("value") + "\n");
                    tv1.setText(tv1.getText() + "quality : " + eElement.getAttribute("quality") + "\n");
                    tv1.setText(tv1.getText() + "-----------------------");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

