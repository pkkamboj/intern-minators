const express = require("express");
const bcrypt = require("bcryptjs");
const router = express.Router();
const config = require("config");
const jwt = require("jsonwebtoken");

const users = require("../../users");
// const auth = require("../../middleware/auth");

// @route POST api/auth/login
// @desc Login user
// @access Public
router.post("/login", (req, res) => {
  const { username, password } = req.body;

  // Simple validation
  if (!username || !password) {
    return res.status(400).json({ msg: "Please enter all fields" });
  }

  var user = users.find(user => user.username === username);

  bcrypt.compare(password, user.password).then(isMatch => {
    if (!isMatch) return res.status(400).json({ msg: "Invalid credentials" });

    jwt.sign({ id: user.id }, config.get("jwtSecret"), (err, token) => {
      if (err) throw err;

      res.json({
        token,
        user: {
          id: user.id,
          username: user.user
        }
      });
    });
  });
});

// @route POST api/auth/signup
// @desc Register new user
// @access Public
router.post("/signup", (req, res) => {
  const { username, password } = req.body;

  // Simple validation
  if (!username || !password) {
    return res.status(400).json({ msg: "Please enter all fields" });
  }

  // Chec for an existing user
  var user = users.find(user => user.username === username);

  if (user) return res.status(400).json({ msg: "User already exists" });

  var newUser = {
    id: Math.floor(Math.random() * 1000),
    username,
    password
  };

  bcrypt.genSalt(10, (err, salt) => {
    if (err) console.log(err);

    bcrypt.hash(newUser.password, salt, (err, hash) => {
      if (err) console.log(err);

      newUser.password = hash;
      users.push(newUser);

      jwt.sign({ id: newUser.id }, config.get("jwtSecret"), (err, token) => {
        if (err) throw err;

        res.json({
          token,
          user: {
            id: newUser.id,
            name: newUser.name,
            email: newUser.email
          }
        });
      });
    });
  });
});

module.exports = router;
