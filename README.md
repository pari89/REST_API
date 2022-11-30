# REST_API
Steps to create a project:
  1. New Maven Project => next=> Filter = Jersey -> GroupId = org.glassfish.jersey.archetypes, ArtifactId = jersey-quickstart-webapp, Version = 3.1.0 => Give GroupId and ArtifactId=>Finish
  2. The project will get built, type Y in the console when it asks
  3. There will be an error in pom file, add the following pulgin
         <plugin>
              <groupId>org.apache.maven.plugins</groupId>
              <artifactId>maven-war-plugin</artifactId>
              <version>3.3.1</version>
          </plugin>
  4. There will be an error in the project, add the following dependencies in the pom.xml
         <dependency>
              <groupId>jakarta.xml.bind</groupId>
              <artifactId>jakarta.xml.bind-api</artifactId>
              <version>3.0.1</version>
          </dependency>
            <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>4.0.1</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.glassfish.jersey.media</groupId>
            <artifactId>jersey-media-json-binding</artifactId>
        </dependency>
   5. There will be an errorin the index.html, for resolving this right click on the project => Build Path=> Configure Build Path=> Project Facet=> Runtimes=>Tomcat 10
   6. Now right click on the project => Maven=> Update Project=> select force update=> Ok
   7. Now your Rest project is ready to work on.
   8. User jakarta instead of javax
