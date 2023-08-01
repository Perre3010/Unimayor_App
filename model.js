const mongoose = require('mongoose');

const ejemploSchema = new mongoose.Schema({
  codigo: Number,
  alumno: String,
  periodo: Number,
  nom_materia: String,
  apreciacion: String,
  total_faltas: Number,
  nota_examen1: Number,
  nota_examen2: Number,
  nota_examen3: Number,
  nota_definitiva: Number,
  nota_habilitacion: Number,
  horario: String,
  docente: String
});

module.exports = mongoose.model('alumnos', ejemploSchema);
