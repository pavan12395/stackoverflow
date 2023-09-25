
// Define the URL of the endpoint you want to test
const endpointUrl = 'http://localhost:5000/userAdded'; // Replace with your actual URL

// Make an HTTP GET request to the endpoint using the Fetch API

const requestOptions = {
    method: "POST",
    headers: {
      "Authorization": "AIzaSyDaGmWKa4JsXZ-HjGw7ISLn_3namBGewQe" // Replace with your actual API key
    }
}
fetch(endpointUrl,requestOptions)
  .then((response) => {
    if (!response.ok) {
      throw new Error(`HTTP Error! Status: ${response.status}`);
    }
    return response.text(); // or response.json() if expecting JSON data
  })
  .then((data) => {
    console.log('HTTP Response:', data);
  })
  .catch((error) => {
    console.error('Fetch Error:', error);
  });
