require('./db');
const fs = require('fs');
const https = require('https');
const express = require('express');
const Ejemplo = require('./model'); // Reemplaza './model' con la ruta correcta del archivo que contiene el esquema de 'Alumnos'

const app = express();
const port = ; // Cambiamos el puerto a 443 para HTTPS

app.use(express.json());

// Cargar el certificado para HTTPS
const privateKey = fs.readFileSync('C:/Users/crist/Desktop/Unimayor/certificados/mi_certificado.key', 'utf8');
const certificate = fs.readFileSync('C:/Users/crist/Desktop/Unimayor/certificados/mi_certificado.crt', 'utf8');
const credentials = { key: privateKey, cert: certificate };

// Configurar el servidor HTTPS
const httpsServer = https.createServer(credentials, app);

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

// Obtener notas del estudiante por código
app.get('/estudiante/:codigo/notas', async (req, res) => {
  try {
    const codigoEstudiante = req.params.codigo;
    const materias = await Ejemplo.find(
      { codigo: codigoEstudiante },
      'nom_materia nota_examen1 nota_examen2 nota_examen3 nota_definitiva'
    );

    if (materias.length === 0) {
      return res.status(404).json({ message: 'Estudiante no encontrado o sin materias' });
    }

    res.json(materias);
  } catch (error) {
    console.error('Error al obtener las materias del estudiante por código:', error);
    res.status(500).send('Error en el servidor');
  }
});

httpsServer.listen(port, () => {
  console.log(`Servidor HTTPS escuchando en el puerto ${port}`);
  console.log(`Servidor iniciado en https://localhost:${port}`);
});

