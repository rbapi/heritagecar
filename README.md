                                                ## HeritageCars API
### 1. For registration your app in Google App, perform the following steps:

* Go to https://console.developers.google.com and login with your Google account (this will be the developer account and the email of this account will be published when someone tries to authenticate with the Google application).
* If you don't have a project create a new one and then click into the project.
* In the menu "API manager" on the left side select "Credentials" --> "Create credentials" --> "OAuth client ID".

![alt tag](https://drive.google.com/open?id=0B3zMjegjNJguUm5lMWwzWkpSQ0k)

* Application Type -> "Web Application",
* Authorized Javascript Origins -> " ", 
* Authorized Redirect URI -> [http://localhost:8181/google/login](http://localhost:8181/google/login)

![alt tag](https://drive.google.com/open?id=0B3zMjegjNJguUHRmTnp1dUFZeUE)

* Copy the client ID and client Secret and update the `application.yml`

![alt tag](https://drive.google.com/open?id=0B3zMjegjNJguZlMwV1dVWnJCaWM)
  
### 2. To run this application use:

```bash
mvn spring-boot:run
  ```

###3. Open browser and browse at 
[http://localhost:8181/google/login](http://localhost:8181/google/login)
