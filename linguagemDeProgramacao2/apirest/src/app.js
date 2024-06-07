const Koa = require('koa')
const router = require('./routes/routes.js')
const bodyParser = require('koa-bodyparser')

const app = new Koa();
app.use(bodyParser());
app.use(router.routes());

app.use(router.routes()).use(router.allowedMethods());

const PORT = process.env.PORT || 3000;

app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});