const redis = require("redis"); // redis is a module
const client = redis.createClient();

client
    .connect()
    .then(async (res) => {
        console.log("connected");

        client.on("error", function (error) {
            console.error(error);
        });

        await client.set("baseCost", 129.99);
        const baseCost = await client.get("baseCost");
        console.log(baseCost);

        await client.set("test", "test value");
        console.log(await client.get("test"));
    });

