using BBC1withLoremIpsum;
using BBC1withLoremIpsum.PageObjects;
using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;
using System;

namespace BBC1withLoremIpsum.PageObjects
{
    public class BasePage
    {
        protected readonly IWebDriver _webDriver;
        private readonly int _timeToWait = 30;
        private readonly string _domen = "gmail.com";
        private readonly string _codeCountry = "+380";
        private readonly int _lengthPhone = 9;
        private readonly By _closeWindowRegistration = By.XPath("//button[@class='tp-close tp-active']");

        public string Question => DataContext.Question;
        public string Name => DataGenerator.GenerateRandomString(DataGenerator.GenerateRandomNumber(2,10));
        public string Email => DataGenerator.GenerateRandomEmail(_domen,DataGenerator.GenerateRandomNumber(5,10));
        public string Number => DataGenerator.GenerateRandomPhoneNumber(_codeCountry,_lengthPhone);
        public string Location => DataGenerator.GenerateRandomString(DataGenerator.GenerateRandomNumber(2, 10));
        public string Age => DataGenerator.GenerateRandomNumber(18,80).ToString();

        public BasePage(IWebDriver webDriver)
        {
            _webDriver = webDriver;
        }
        public void WaitForPageLoad()
        {
            _webDriver.Manage().Timeouts().PageLoad = TimeSpan.FromSeconds(_timeToWait);
        }
       
        public void WaitForElement(IWebElement element)
        {
            WebDriverWait wait = new WebDriverWait(_webDriver, TimeSpan.FromMinutes(_timeToWait));
            wait.IgnoreExceptionTypes(typeof(NoSuchElementException));
            wait.IgnoreExceptionTypes(typeof(StaleElementReferenceException));
        }
        public void CloseWindowRegistration()
        {
            if (_webDriver.FindElement(_closeWindowRegistration).Displayed)
            {
                _webDriver.FindElement(_closeWindowRegistration).Click();
            }
        }
        public string GenerateLoremQuestion()
        {
            var loremHome = new LoremHome(_webDriver);
            return loremHome.GenerateLorem().GetTextParagraph(DataGenerator.GenerateRandomNumber(1,5));
        }
    }
}
