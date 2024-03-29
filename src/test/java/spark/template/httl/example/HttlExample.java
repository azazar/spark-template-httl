/*
 * Copyright 2013 Per Wendel
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package spark.template.httl.example;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.httl.HttlTemplateEngine;

import static spark.Spark.get;

/**
 * HttlTemplateRoute example.
 */
public final class HttlExample {

    public static void main(String[] args) {

        get("/hello", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("message", "Hello Httl");
            return new ModelAndView(model, "hello.httl"); // located in the resources directory
        }, new HttlTemplateEngine());

    }

}
