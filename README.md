# Process Centric Service (REST)

The **process centric service** is the service that receives requests from the **client** (user interface) and redirects them to the right module below. It integrates both **business logic service** methods and **storage data service** methods;

| resource | link |
|----------|------|
| API documentation | http://docs.processcentricservice1.apiary.io/ |
| Heroku base URL | https://process-centric-service-ar.herokuapp.com/rest/ |

### How to run it
Since the server is already deployed on Heroku, it is only needed to go to the Heroku base URL. However, you can also deploy again the server on Heroku via ant.

**Optional**: If you want to try the server locally, you can follow the steps below:
* **Clone** the repo: `git clone https://github.com/service-engineering-final-project/process_centric_service.git`;
* **Navigate** into the project folder: `cd process_centric_service`;
* **Install** the packages needed: `ant install`;
* **Run** the server using ant: `ant execute.server`.