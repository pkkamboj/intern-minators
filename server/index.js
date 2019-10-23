const express = require("express");
const config = require("config");
const app = express();

app.use(express.json());

// DB Config
const dbUri = config.get("mongoURI");

// Routes
app.use("/api/auth", require("./routes/api/auth"));

app.listen(3000);
