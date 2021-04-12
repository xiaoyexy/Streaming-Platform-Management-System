// a simple http server

const Koa = require('koa');
const fs = require('fs');

const app = new Koa();
const appid = process.env.APPID
// const appid=3001

async function doReadFile () {
    const data = await  fs.readFileSync('stats/index.html');
    return data;
}

app.use(async (ctx, next) => {
    await next();
    var data = await doReadFile();
    ctx.response.type = 'text/html';
    ctx.response.body = data;
    ctx.response.set('X-Response-Container-id', `${appid} is called`);
});


app.listen(appid);
// console.log(`app started at port ${appid}...`);