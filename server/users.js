const bcrypt = require("bcryptjs");

var users = [
  {
    id: "123",
    username: "temp123",
    password: ""
  }
];

const tempUser = {
  id: "123",
  username: "temp123",
  password: ""
};

// Create salt & hash
bcrypt.genSalt(10, (err, salt) => {
  bcrypt.hash("password", salt, (err, hash) => {
    if (err) throw err;
    users[0].password = hash;
  });
});

module.exports = users;
