# Smart Race Event Notifier

## For User

### About this app

- This is a companion app for the great smartrace app. See [smartrace.de](https://www.smartrace.de/en/)
  and [buy them a coffee](https://www.smartrace.de/en/buy-me-a-coffee/).
- It uses the data interface, which is a paid feature.
- It just shows all your race events without any validating or processing.

### Disclaimer

- This is a proof of concept which might be of interest to others.
- It's hosted on free tier on render.com. Expect sluggy performance and downtimes.
- **ATTENTION:** It shows the complete event to every person opening this site. So don't put any confidential
  information in your drivers names.

### Usage

- Buy and enable the data interface in the smartrace app.
- Go to settings and
  enter [https://smartrace-event-handler.onrender.com/api](https://smartrace-event-handler.onrender.com/api) and select
  the events you want to see.
- Click `Events` in the menu on the left to see your events.
- Optional: These page shows all events of all users. So filter your events by source ip with the filterfield.
- Please remove this site from your settings or disable the data interface if you don't use it anymore to keep the
  server load down.
- Questions? Error? Problems? Find me on [SmartRace@Discord](https://discord.com/invite/VSpuTHAMDu)
  or [Github](https://github.com/watho/ioBroker.smart-race-event-receiver)

## For Developer

### Running the application

The project is a standard Maven project. To run it from the command line,
type `mvnw` (Windows), or `./mvnw` (Mac & Linux), then open
http://localhost:8080 in your browser.

You can also import the project to your IDE of choice as you would with any
Maven project. Read more
on [how to import Vaadin projects to different IDEs](https://vaadin.com/docs/latest/guide/step-by-step/importing) (
Eclipse, IntelliJ IDEA, NetBeans, and VS Code).

### Deploying to Production

To create a production build, call `mvnw clean package -Pproduction` (Windows),
or `./mvnw clean package -Pproduction` (Mac & Linux).
This will build a JAR file with all the dependencies and front-end resources,
ready to be deployed. The file can be found in the `target` folder after the build completes.

Once the JAR file is built, you can run it using
`java -jar target/sr-event-notifier-1.0-SNAPSHOT.jar`

### Project structure

- `MainLayout.java` in `src/main/java` contains the navigation setup (i.e., the
  side/top bar and the main menu). This setup uses
  [App Layout](https://vaadin.com/docs/components/app-layout).
- `views` package in `src/main/java` contains the server-side Java views of your application.
- `views` folder in `frontend/` contains the client-side JavaScript views of your application.
- `themes` folder in `frontend/` contains the custom CSS styles.

### Useful links

- Read the documentation at [vaadin.com/docs](https://vaadin.com/docs).
- Follow the tutorial at [vaadin.com/docs/latest/tutorial/overview](https://vaadin.com/docs/latest/tutorial/overview).
- Create new projects at [start.vaadin.com](https://start.vaadin.com/).
- Search UI components and their usage examples
  at [vaadin.com/docs/latest/components](https://vaadin.com/docs/latest/components).
- View use case applications that demonstrate Vaadin capabilities
  at [vaadin.com/examples-and-demos](https://vaadin.com/examples-and-demos).
- Build any UI without custom CSS by discovering Vaadin's set
  of [CSS utility classes](https://vaadin.com/docs/styling/lumo/utility-classes).
- Find a collection of solutions to common use cases at [cookbook.vaadin.com](https://cookbook.vaadin.com/).
- Find add-ons at [vaadin.com/directory](https://vaadin.com/directory).
- Ask questions on [Stack Overflow](https://stackoverflow.com/questions/tagged/vaadin) or join
  our [Discord channel](https://discord.gg/MYFq5RTbBn).
- Report issues, create pull requests in [GitHub](https://github.com/vaadin).

## Deploying using Docker

To build the Dockerized version of the project, run

```
mvn clean package -Pproduction
docker build . -t sr-event-notifier:latest
```

Once the Docker image is correctly built, you can test it locally using

```
docker run -p 8080:8080 sr-event-notifier:latest
```
