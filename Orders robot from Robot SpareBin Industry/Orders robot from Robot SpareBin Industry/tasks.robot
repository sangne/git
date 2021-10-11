*** Settings ***
Documentation  Orders robots from RobotSpareBin Industries Inc.
...            Saves the order HTML receipt as a PDF file.
...            Saves the screenshot of the ordered robot.
...            Embeds the screenshot of the robot to the PDF receipt.
...            Creates ZIP archive of the receipts and the images.
Library        RPA.Browser
Library        RPA.HTTP
Library        RPA.Tables
Library        RPA.PDF
Library        Screenshot
Library        RPA.Archive
Library        RPA.Robocorp.Vault


# +
*** Keywords ***

Open the intranet website
      Open Available Browser   https://robotsparebinindustries.com/#/robot-order

# +
*** Keywords ***

Close the annoying modal

       Click Button  Xpath://*[@id="root"]/div/div[2]/div/div/div/div/div/button[1]

# +
*** Keywords ***

Fill the form For Each Order

      [Arguments]   ${Order}
      Wait Until Element Is Enabled    head 
      Select From List By Value  head  ${Order}[Head]
      Wait Until Element Is Enabled    body 
      Select Radio Button    body    ${Order}[Body]
      Wait Until Element Is Enabled    Xpath:/html/body/div/div/div[1]/div/div[1]/form/div[3]/input 
      Input Text  Xpath:/html/body/div/div/div[1]/div/div[1]/form/div[3]/input  ${Order}[Legs]
      Wait Until Element Is Enabled    address 
      Input Text   address     ${Order}[Address]
      Wait Until Element Is Enabled     id:preview 
      Click Button    id:preview
      Wait Until Element Is Enabled  id:order 
      Click Button    id:order
# -

*** Keywords ***
Download Excel File
      

      Download   https://robotsparebinindustries.com/orders.csv

# +
*** Keywords ***

Read the orders from excel file

      ${Orders}=   Read table from CSV    orders.csv  
      
      FOR  ${Order}   IN  @{Orders}  
         
         Fill the form For Each Order    ${Order}
         
         ${pdf}=  Store the receipt as a PDF file  ${Order}
         
         ${screenshot}=  Take screenshot of the robot image   ${Order}
         
         Embed the robot screenshot to the receipt PDF file   ${Order}
         
         Click Button    id:order-another
         
         Close the annoying modal
          
      END
     
# -

*** Keywords ***

 Store the receipt as a PDF file
      [Arguments]        ${Order}
       Wait Until Element Is Visible    id:receipt
      ${Order_Receipt_Html}=    Get Element Attribute    id:receipt   outerHTML
       ${pdf}=   Html To Pdf   ${Order_Receipt_Html}  ${CURDIR}${/}output${/}${Order}[Order number].pdf


*** Keywords ***
Take screenshot of the robot image
    
      [Arguments]        ${Order}
       ${screenshot}=  Capture Element Screenshot    id:robot-preview-image   ${CURDIR}${/}image${/}${Order}[Order number].png

*** Keywords ***
Read some data from vault
 
         ${secret}=    Get Secret    credentials

        Log    ${secret}[message]


# +
*** Keywords ***

Embed the robot screenshot to the receipt PDF file 
          [Arguments]   ${order}
          
          Open PDF    ${CURDIR}${/}output${/}${Order}[Order number].pdf
          
           @{myfiles}=   Create List    ${CURDIR}${/}image${/}${Order}[Order number].png  
          
          Add Files To Pdf  ${myfiles}    ${CURDIR}${/}output${/}${Order}[Order number].pdf  ${True}
          
          Close Pdf    ${CURDIR}${/}output${/}${Order}[Order number].pdf


# +
*** Keywords ***

Create a zip file

    Archive Folder With Zip    ${CURDIR}${/}output    ${CURDIR}${/}output${/}pdf_archive.zip

# +
*** Tasks ***

Order robots from RobotSpareBin Industries Inc
    Open the intranet website  
    Close the annoying modal
    Download Excel File
    Read the orders from excel file
    Create a zip file
    Read some data from vault
    
