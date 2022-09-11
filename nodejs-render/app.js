const express = require('express')
const app = express()
const port = process.env.PORT || 3001;

app.get('/', (req, res) => {
  res.send('Express hosting on Render.com')
})

app.listen(port, () => {
  console.log(`Listening on port ${port}`)
})