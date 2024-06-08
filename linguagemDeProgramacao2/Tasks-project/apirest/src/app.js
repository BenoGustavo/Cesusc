const Koa = require('koa')
const router = require('./routes/routes.js')
const bodyParser = require('koa-bodyparser')
const morgan = require('koa-morgan')

require('./db/db.associations.js');

const app = new Koa();
app.use(bodyParser());
app.use(morgan('dev'));
app.use(router.routes());

app.use(router.routes()).use(router.allowedMethods());

const PORT = process.env.PORT || 3000;

app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});