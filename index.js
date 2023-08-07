require('./db');

const express = require('express');
const Ejemplo = require('./model');

const app = express();
const port = process.env.port || 3000;

app.use(express.json());

// Obtener todos los ejemplos
app.get('/estudiante', async (req, res) => {
  try {
    const ejemplos = await Ejemplo.find();
    res.json(ejemplos);
  } catch (error) {
    console.error('Error al obtener los ejemplos:', error);
    res.status(500).send('Error en el servidor');
  }
});

// Obtener materias y horarios del estudiante por código
app.get('/estudiante/:codigo/horarios', async (req, res) => {
  try {
    const codigoEstudiante = req.params.codigo;
    const materias = await Ejemplo.find({ codigo: codigoEstudiante }, 'horario nom_materia');
    
    if (materias.length === 0) {
      return res.status(404).json({ message: 'Estudiante no encontrado o sin materias' });
    }

    res.json(materias);
  } catch (error) {
    console.error('Error al obtener las materias del estudiante por código:', error);
    res.status(500).send('Error en el servidor');
  }
});

// Obtener notas del estudiante por codigo
app.get('/estudiante/:codigo/notas', async (req, res) => {
  try {
    const codigoEstudiante = req.params.codigo;
    const materias = await Ejemplo.find({ codigo: codigoEstudiante }, 'nom_materia nota_examen1 nota_examen2 nota_examen3 nota_definitiva nota_habilitacion');
    
    if (materias.length === 0) {
      return res.status(404).json({ message: 'Estudiante no encontrado o sin materias' });
    }

    res.json(materias);
  } catch (error) {
    console.error('Error al obtener las materias del estudiante por código:', error);
    res.status(500).send('Error en el servidor');
  }
});


// Iniciar el servidor
app.listen(port, () => {
  console.log(`Servidor iniciado en http://localhost:${port}`);
});
