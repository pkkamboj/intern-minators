const express = require("express");
const config = require("config");
const app = express();
const mongoose = require("mongoose");

app.use(express.json());

// DB Config
const dbUri = config.get("mongoURI");

mongoose
  .connect(dbUri, {
    useNewUrlParser: true,
    useCreateIndex: true,
    useUnifiedTopology: true
  })
  .then(() => console.log("MongoDB connected... "))
  .catch(err => console.log(err));

// Routes
app.use("/api/auth", require("./routes/api/auth"));

app.listen(3000);
