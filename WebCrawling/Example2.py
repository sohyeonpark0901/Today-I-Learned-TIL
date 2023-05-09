import time
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.action_chains import ActionChains
import pandas as pd

chrome = ChromeDriverManager().install()

service = Service(chrome)
driver = webdriver.Chrome(service=service)

try:
    driver.get('https://www.daangn.com/')

    elem = driver.find_element(By.ID, 'header-search-input')
    elem.send_keys('모자')
    elem.send_keys(Keys.RETURN)
    time.sleep(2)

    page = 1
    while True:
        div = driver.find_element(By.ID, 'flea-market-wrap')
        posts = div.find_elements(By.CLASS_NAME, 'article-title')

        if page < 3:
            page = page + 1
            more = driver.find_element(By.CLASS_NAME, 'more-btn')
            more.click()
            time.sleep(2)
        else:  # 버튼 다 하고 자료 수집
            a_count = 0
            b = []
            for post in posts:
                a_count = a_count + 1
                a = post.text
                b.append(a)
                if a_count == 30:
                    print(b)
                    values = {"데이터": b}
                    df = pd.DataFrame(values)

            break

    time.sleep(2)

except Exception as e:
    print(e)
finally:
    driver.close()
    driver.quit()

