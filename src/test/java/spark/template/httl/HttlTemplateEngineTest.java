package spark.template.httl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import spark.ModelAndView;

import static org.junit.Assert.*;

public class HttlTemplateEngineTest {

    @Test
    public void test_render() throws Exception {
        String templateVariable = "Hello Httl!";
        Map<String, Object> model = new HashMap<>();
        model.put("message", templateVariable);
        String expected = String.format("<h1>%s</h1>", templateVariable);
        String actual = new HttlTemplateEngine("UTF-8").render(new ModelAndView(model, "hello.httl"));
        assertEquals(expected, actual);
    }

}