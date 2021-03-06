/*
 *
 *  Copyright 2015-2017 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *
 */
package springfox.documentation.spring.web.dummy.controllers;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.dummy.models.Example;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bugs")
public class BugsController {
  @RequestMapping(value = "1306", method = RequestMethod.POST)
  public ResponseEntity<Map<String, String>> bug1306(@RequestParam Map<String, String> paramMap) {
    return ResponseEntity.ok(null);
  }

  @ApiImplicitParams(
      @ApiImplicitParam(dataType = "string", allowMultiple = true, paramType = "header")
  )
  @RequestMapping(value = "1209", method = RequestMethod.POST)
  public ResponseEntity<String> bug1209() {
    return ResponseEntity.ok("");
  }

  @RequestMapping(value = "1162", method = RequestMethod.POST)
  public ResponseEntity<Date> bug1162() {
    return ResponseEntity.ok(new Date(new java.util.Date().getTime()));
  }

  @RequestMapping(value = "1376-bare", method = RequestMethod.POST)
  public URL issue1376Bare() throws MalformedURLException {
    return new URL("http://example.org");
  }

  @RequestMapping(value = "1376-property", method = RequestMethod.POST)
  public Bug1376 issue1376Property() throws MalformedURLException {
    return new Bug1376(new URL("http://example.org"));
  }

  @RequestMapping(value = "1376-input-bare", method = RequestMethod.POST)
  public void issue1376Input(URL url) throws MalformedURLException {
  }

  @RequestMapping(value = "1376-input-property", method = RequestMethod.POST)
  public void issue1376Input(Bug1376 bug) throws MalformedURLException {
  }

  @RequestMapping(value = "1420", method = RequestMethod.GET)
  @ApiOperation(tags = {"foo"}, value = "issue1420")
  public String issue1420() {
    return "1420";
  }

  @RequestMapping(value = "1440", method = RequestMethod.GET)
  public Resource<String> issue1440() {
    return new Resource<String>("1420");
  }

  @RequestMapping(value = "1475", method = RequestMethod.GET)
  public Map<String, List<String>> mapOfLists() {
    throw new UnsupportedOperationException();
  }

  @RequestMapping(value = "1475-example", method = RequestMethod.GET)
  public Map<String, List<Example>> mapOfListOfExample() {
    throw new UnsupportedOperationException();
  }

  @RequestMapping(value = "1605", method = RequestMethod.GET)
  public byte[] byteArrayResponse() {
    throw new UnsupportedOperationException();
  }

  @RequestMapping(value = "1676", method = RequestMethod.GET)
  public void apiModelProperty(@RequestBody Bug1676 value) {
    throw new UnsupportedOperationException();
  }

  @RequestMapping(value = "1632", method = RequestMethod.GET)
  public void fileCustomType(@RequestBody File value) {
    throw new UnsupportedOperationException();
  }

  @RequestMapping(value = "1632s", method = RequestMethod.GET)
  public void filesCustomType(@RequestBody List<File> values) {
    throw new UnsupportedOperationException();
  }

  @RequestMapping(value = "1697", method = RequestMethod.GET)
  public void payloadWithByteBuffer(@RequestBody Bug1697 body) {
    throw new UnsupportedOperationException();
  }

  class Bug1697 {
    public ByteBuffer getBar() {
      return bar;
    }

    public void setBar(ByteBuffer bar) {
      this.bar = bar;
    }

    private ByteBuffer bar;
  }


  class File {
    private String name;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }

  class Bug1676 {
    @ApiModelProperty(value = "Horizontal position", required=false, example="200")
    private float xAxis;
    @ApiModelProperty(value = "Vertical position", required=false, example="500")
    private float yAxis;

    public float getxAxis() {
      return xAxis;
    }

    public void setxAxis(float xAxis) {
      this.xAxis = xAxis;
    }

    public float getyAxis() {
      return yAxis;
    }

    public void setyAxis(float yAxis) {
      this.yAxis = yAxis;
    }
  }
  
  class Bug1376 {

    URL url;
    public Bug1376(URL url) {
      this.url = url;
    }

    public URL getUrl() {
      return url;
    }

    public void setUrl(URL url) {
      this.url = url;
    }

  }

  public class LinkAlternate {
    private String href;

    public String getHref() {
      return href;
    }

    public void setHref(String href) {
      this.href = href;
    }
  }

}
