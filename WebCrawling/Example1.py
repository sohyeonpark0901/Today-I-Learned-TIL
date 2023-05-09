import time
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys

chrome = ChromeDriverManager().install()

service = Service(chrome)
driver = webdriver.Chrome(service=service)

try:
    driver.get('https://cafe.naver.com/joonggonara')

    elem = driver.find_element(By.ID, 'topLayerQueryInput')
    elem.send_keys('자전거')
    elem.send_keys(Keys.RETURN)

    time.sleep(1)

    iframe = driver.find_element(By.ID, 'cafe_main')
    driver.switch_to.frame(iframe)

    for page in range(9, 13):
        divs = driver.find_elements(By.CLASS_NAME, 'article-board')
        div = divs[1]

        trs = div.find_elements(By.XPATH, './table/tbody/tr')
        print(trs)
        for tr in trs:
            atag = tr.find_element(By.CLASS_NAME, 'article')
            print(atag.text)

        #         if str(page)[-1] == '1':
        if page % 10 == 1:
            page_btn = driver.find_element(By.CLASS_NAME, 'pgR')
        else:
            page_btn = driver.find_element(By.LINK_TEXT, str(page))

        page_btn.click()

    #     driver.switch_to.default_content()

    time.sleep(3)
except Exception as e:
    print(e)
finally:
    driver.close()
    driver.quit()