const puppeteer = require('puppeteer')

const scrapeWebpage = async () => {

    console.log('Launch Browser and Create tag cum page')
    const browser = await puppeteer.launch({
        dumpio: true
    });
    const page = await browser.newPage()

    // visit page
    const url = 'http://automationpractice.com/index.php';
    await page.goto(`${url}`)

    // take screenshot 
    await page.screenshot({ path: `screenshots/landing_page.png`, fullPage: true })

    // evaluate page
    var productNames = await page.evaluate(() => {
        var ulEl = Array.from(document.querySelectorAll("ul#homefeatured"))

        var names = []
        var liEL = ulEl[0].getElementsByTagName("li")
        for (var i = 0; i < liEL.length; i++) {
            names.push({
                product: liEL[i].getElementsByClassName("right-block")[0].getElementsByTagName("h5")[0].getElementsByTagName("a")[0].text.replace(/\t/g, '').replace(/\n/g, ''),
                price: liEL[i].getElementsByClassName("right-block")[0].querySelector('div[itemprop="offers"]').querySelector('span[itemprop="price"]').innerText
            })

        }
        return names
    });

    // print extracted product names and its price.
    console.log(productNames)

    // Navigate to Sign In Page http://automationpractice.com/index.php?controller=authentication&back=my-account
    await page.click("a.login");
    await page.waitForSelector('form#create-account_form');
    console.log(page.url())

    // close browser, else program will keep running.
    await browser.close()
}

(async () => {
    await scrapeWebpage();
})();