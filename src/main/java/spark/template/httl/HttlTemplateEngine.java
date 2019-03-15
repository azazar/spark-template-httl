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
package spark.template.httl;

import httl.*;
import spark.ModelAndView;
import spark.TemplateEngine;

import java.io.IOException;
import java.io.StringWriter;
import java.text.ParseException;
import java.util.Map;
import java.util.Properties;

/**
 * Template Engine based on Httl.
 */
public class HttlTemplateEngine extends TemplateEngine {

    private final Engine engine;
    private String encoding;

    /**
     * Constructor
     */
    public HttlTemplateEngine() {
        Properties properties = new Properties();
        properties.setProperty("loaders", "httl.spi.loaders.ClasspathLoader");
        this.engine = Engine.getEngine(properties);
    }

    /**
     * Constructor
     *
     * @param encoding The encoding to use
     */
    public HttlTemplateEngine(String encoding) {
        this();
        this.encoding = encoding;
    }

    /**
     * Constructor
     *
     * @param httlEngine The httl engine, must not be null.
     */
    public HttlTemplateEngine(Engine httlEngine) {
        if (httlEngine == null) {
            throw new IllegalArgumentException("engine must not be null");
        }
        this.engine = httlEngine;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String render(ModelAndView modelAndView) {
        Object model = modelAndView.getModel();

        if (model instanceof Map) {
            StringWriter writer = new StringWriter();

            try {
                engine.getTemplate(modelAndView.getViewName()).render(model, writer);
            } catch (IOException | ParseException ex) {
                throw new RuntimeException(ex);
            }

            return writer.toString();
        } else {
            throw new IllegalArgumentException("modelAndView must be of type java.util.Map");
        }
    }

}