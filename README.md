XML-Parsing 

# file.xml :
<?xml version="1.0"?>
        <server>
              <vars>
                  <var name="TT_BBT1" value="4.32292" quality="192"/>
                  <var name="GVS_BBT1" value="false" quality="192"/>
                  <var name="A_23" value="true" quality="0"/>
                  <var name="A_43" value="03.32" quality="0"/>
              </vars>
        </server>
# Read Xml File:

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

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



![](https://raw.githubusercontent.com/Priyanka-Mohanty/XML-Parsing/master/app/src/main/res/drawable/screenshot.png)
