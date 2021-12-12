
fetch(
    "https://api.openweathermap.org/data/2.5/weather?q=" +
    "Burgas"+
    "&units=metric&appid=" +
    apiKey
)
    .then((response) => response.json())
    .then((data) => console.log(data));