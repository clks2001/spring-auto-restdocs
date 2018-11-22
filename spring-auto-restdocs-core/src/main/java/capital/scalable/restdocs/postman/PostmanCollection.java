/*-
 * #%L
 * Spring Auto REST Docs Core
 * %%
 * Copyright (C) 2015 - 2018 Scalable Capital GmbH
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package capital.scalable.restdocs.postman;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class PostmanCollection {
    Info info = new Info();
    List<Item> item = new ArrayList<>();

    PostmanCollection(String name, String description) {
        this.info.name = name;
        this.info.description = description;
    }

    static class Info {
        String name;
        String description;
        String schema = "https://schema.getpostman.com/json/collection/v2.1.0/collection.json";
    }

    static class Item {
        String name;
        Request request = new Request();
        List<Response> response = new ArrayList<>();
    }

    static class Request {
        Auth auth = new Auth();
        String method;
        List<Header> header = new ArrayList<>();
        Body body = new Body();
        Url url = new Url();
        String description;
    }

    static class Response {
        String name;
        List<Header> header = new ArrayList<>();
        String body;
        String status;
        int code;
        Request originalRequest;
    }

    @JsonInclude(NON_EMPTY)
    static class Auth {
        String type = "noauth";
        List<Basic> basic = new ArrayList<>();
    }

    static class Basic {
        String key;
        String value;
        String type;
    }

    static class Header {
        String key;
        String name;
        String value;
        String type;

        Header(String key, String value) {
            this.key = key;
            this.name = key;
            this.value = value;
            this.type = "text";
        }
    }

    static class Body {
        String mode;
        String raw;
    }

    static class Url {
        String raw;
        String protocol;
        List<String> host = new ArrayList<>();
        String port;
        List<String> path = new ArrayList<>();
        List<Query> query = new ArrayList<>();
    }

    static class Query {
        String key;
        String value;

        Query(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}