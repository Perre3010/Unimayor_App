const mongoose = require('mongoose');

mongoose.Promise = global.Promise;
mongoose.connect('mongodb+srv://perreke3010:<perreke3010>@cluster0.shcqvr3.mongodb.net/Alumnos', {
  useNewUrlParser: true,
  useUnifiedTopology: true,
})
  .then(() => {
    console.log('Conexión exitosa a la base de datos MongoDB');
  })
  .catch((error) => {
    console.error('Error al conectar a la base de datos MongoDB:', error);
  });
