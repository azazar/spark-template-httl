spark-template-httl 
==============================================

Maven dependency:

```xml
<dependency>
    <groupId>com.github.azazar</groupId>
    <artifactId>spark-template-httl</artifactId>
    <version>2.8.0</version>
</dependency>
```

How to use the Httl template route for Spark example:

```java
import static spark.Spark.get;

import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.template.httl.HttlTemplateEngine;

/**
 * HttlTemplateRoute example.
 */
public final class HttlExample {
    
    public static void main(final String[] args) {

        get("/hello", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("hello", "Httl World");
            model.put("person", new Person("Foobar"));

            // The vm files are located under the resources directory
            return new ModelAndView(model, "hello.httl");
        }, new HttlTemplateEngine());

    }

    public static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
```
