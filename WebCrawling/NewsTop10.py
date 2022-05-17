import time
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import pandas as pd

chrome = ChromeDriverManager().install()

service = Service(chrome)
driver = webdriver.Chrome(service=service)

try:
    driver.get('https://www.daum.net/')

    elem = driver.find_element(By.CLASS_NAME, 'inner_search')
    elem1 = elem.find_element(By.CLASS_NAME, 'tf_keyword')

    elem1.send_keys('뉴스')
    elem1.send_keys(Keys.RETURN)

    time.sleep(3)

    btn_class = driver.find_element(By.ID,'newsExtMore')
    btn_class.click()
    time.sleep(3)
    div_list = driver.find_element(By.CLASS_NAME, 'list_news')
    divs = div_list.find_elements(By.CLASS_NAME, 'wrap_cont')
    for div in divs:
        result = div.find_element(By.CLASS_NAME,"tit_main")
        print(result.text)

except Exception as e:
    print(e)
finally:
    driver.close()
    driver.quit()