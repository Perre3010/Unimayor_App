const mongoose = require('mongoose');

mongoose.Promise = global.Promise;
mongoose.connect('mongodb://127.0.0.1:27017/Alumnos', {
  useNewUrlParser: true,
  useUnifiedTopology: true,
})
  .then(() => {
    console.log('Conexión exitosa a la base de datos MongoDB');
  })
  .catch((error) => {
    console.error('Error al conectar a la base de datos MongoDB:', error);
  });
