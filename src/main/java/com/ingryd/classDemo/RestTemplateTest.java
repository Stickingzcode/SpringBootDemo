package com.ingryd.classDemo;

import com.ingryd.classDemo.model.JavaStudent;
import com.ingryd.classDemo.model.JavaStudentResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateTest {
    public static void main(String[] args) {
//        instantiate a rest
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/v1/students";
        JavaStudent student = new JavaStudent("Man", "Dan", "Female", 19, "email@gmail.com", "Java1234");
        ResponseEntity<JavaStudent> response = restTemplate.postForEntity(url, student, JavaStudent.class);
        JavaStudent extractedResponse = response.getBody();
        System.out.println(extractedResponse);

//        to get
        String urlTwo = "";
        ResponseEntity<JavaStudent> responseTwo = restTemplate.getForEntity(urlTwo, JavaStudent.class);
        System.out.println(responseTwo.getBody());

//        to put
        String urlFour = "";
        restTemplate.put(urlFour, student);
//        to confirm that the update has been made
        ResponseEntity<JavaStudent> responseThree = restTemplate.getForEntity(url, JavaStudent.class);
        System.out.println(responseThree.getBody());

//        to get resource
        String urlThree = "";
        ResponseEntity<JavaStudentResource> resource = restTemplate.getForEntity(urlTwo, JavaStudentResource.class);
        System.out.println(resource.getBody());
        assert resource.getBody() != null;
//        System.out.println(responseTwo.getBody().getLink());
    }
}
