const express = require("express");
const bcrypt = require("bcryptjs");
const router = express.Router();
const config = require("config");
const jwt = require("jsonwebtoken");
// const auth = require("../../middleware/auth");

const tempUser = {
  id: "123",
  username: "temp123",
  password: ""
};

// Create salt & hash
bcrypt.genSalt(10, (err, salt) => {
  bcrypt.hash("password", salt, (err, hash) => {
    if (err) throw err;
    tempUser.password = hash;
  });
});

// @route POST api/auth
// @desc Auth user
// @access Public
router.post("/", (req, res) => {
  const { username, password } = req.body;

  // Simple validation
  if (!username || !password) {
    return res.status(400).json({ msg: "Please enter all fields" });
  }

  bcrypt.compare(password, tempUser.password).then(isMatch => {
    if (!isMatch) return res.status(400).json({ msg: "Invalid credentials" });

    jwt.sign(
      { id: tempUser.id },
      config.get("jwtSecret"),
      { expiresIn: 3600 },
      (err, token) => {
        if (err) throw err;

        res.json({
          token,
          user: {
            id: tempUser.id,
            username: tempUser.user
          }
        });
      }
    );
  });
});

module.exports = router;
