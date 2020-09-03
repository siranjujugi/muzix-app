import { AppPage } from './app.po';
import { browser, logging, by, element } from 'protractor';


describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should display title Message', () => {
    page.navigateTo();
    expect(browser.getTitle()).toEqual('MuzixApplication');
    browser.driver.sleep(2000);
  });

  it('should redirect to Register', () => {
    browser.element(by.css('.register-button')).click;
    expect(browser.getCurrentUrl()).toContain('/register');
    browser.driver.sleep(2000);
  });

  it('should register', () => {
    browser.element(by.id('userName')).sendKeys('teste2e');
    browser.element(by.id('email')).sendKeys('teste2e');
    browser.element(by.id('password')).sendKeys('teste2e');
    browser.element(by.css('.register-user')).click();
    browser.driver.sleep(2000);
   
  });

  it('should login', () => {
    browser.element(by.id('userName')).sendKeys('teste2e');
    browser.element(by.id('password')).sendKeys('teste2e');
    browser.element(by.css('.login-click')).click();
    browser.driver.sleep(2000);
   
  });


  it('should list track item for India', () => {
    browser.element(by.css(".mat-button")).click();
    browser.driver.sleep(1000);
    browser.element(by.css(".mat-menu-item-india")).click();
    browser.driver.sleep(1000);
    expect(browser.getCurrentUrl()).toContain('/India');
    browser.driver.sleep(500);
  });

  it('should save Indian track to wishlist', () => {
    browser.driver.manage().window().maximize();
    browser.driver.sleep(2000);
    const tracks = element.all(by.css('.example-card'));
    browser.driver.sleep(2000);
    browser.element(by.css('.addButton')).click();  
    browser.driver.sleep(2000);
  });

  it('should list track item for Spain', () => {
    browser.element(by.css(".mat-button")).click();
    browser.driver.sleep(2000);
    browser.element(by.css(".mat-menu-item-spain")).click();
    browser.driver.sleep(2000);
    expect(browser.getCurrentUrl()).toContain('/Spain');
    browser.driver.sleep(1000);
  });

  it('should save track item for spain', () => {
    browser.driver.manage().window().maximize();
    browser.driver.sleep(2000);
    const tracks = element.all(by.css('.example-card'));
    browser.driver.sleep(2000);
    browser.element(by.css('.addButton')).click();  
    browser.driver.sleep(2000);
  });

  it('should get all tracks from wishlist', () => {
    // browser.driver.sleep(2000);
    // const tracks = element.all(by.css('.example-card'));
    browser.driver.sleep(2000);
    browser.element(by.css('.mat-button-wishlist')).click(); 
    browser.driver.sleep(2000); 
    expect(browser.getCurrentUrl()).toContain('/WishList');
    browser.driver.sleep(2000);
  });

  it('should delete tracks from wishlist', () => {
    browser.driver.sleep(2000);
    const tracks = element.all(by.css('.example-card'));
    browser.driver.sleep(2000);
    browser.element(by.css('.deleteButton')).click(); 
    browser.driver.sleep(2000);
  });

  it('should open dialog box to update comments from wishlist', () => {
    browser.driver.sleep(2000);
    const tracks = element.all(by.css('.example-card'));
    browser.driver.sleep(2000);
    browser.element(by.css('.updateButton')).click(); 
    browser.driver.sleep(2000);
  });

  it('should save updated comments from wishlist', () => {
    browser.driver.sleep(2000);
    browser.element(by.css('.matInput')).sendKeys("New Comments");
    browser.driver.sleep(2000);
    browser.element(by.css('.updateCommentDemo')).click(); 
    browser.driver.sleep(2000);
  });

  it('should logout', () => {
    browser.driver.sleep(2000);
    browser.element(by.css('.mat-button-logout')).click();
    browser.driver.sleep(2000);
   
  });


});
