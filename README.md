# food-killer
open API를 활용하여 전국의 음식점을 쉽게 찾을 수 있고 주변 2km반경의 음식점 정보를 받을 수 있는 웹사이트을 개발하였습니다.

# 기능구현

## [메인페이지] ##
-비 로그인 상태에서는 전국의 식당 정보를 확인할 수 있고, 로그인하면 사용자의 현재 위치 주변 2km 반경 내의 식당 정보를 지도에서 확인할 수 있습니다.

<img width="65%" src="https://github.com/pueser/food-killer/assets/117990884/8be4484c-71d6-4224-9326-8eb7aa0cb742"/> 

## [회원가입] ##
-회원가입은 두 단계로 진행됩니다. 첫 번째 단계에서는 이용약관에 동의하고 개인정보를 입력합니다. 두 번째 단계에서는 이메일 인증을 거쳐 비밀번호와 닉네임 등의 정보를 입력하여 회원가입을 완료합니다.<br/> 이 과정은 sessionAttributes를 활용하여 첫 번째와 두 번째 단계의 정보를 관리하며, DB에 저장될 수 있도록 구현되었습니다.

<img width="65%" src="https://github.com/pueser/food-killer/assets/117990884/ad3d3099-e44e-4d18-ae67-5714d9d418af"/> 

## [비밀번호 찾기] ##
-SMTP 프로토콜을 사용하여 이메일 기능을 구현했습니다. 랜덤한 비밀번호 생성에는 Random과 StringBuffer 클래스를 활용하여 기존의 비밀번호 유효성을 준수하는 문자열을 생성했습니다. <br/>생성된 비밀번호는 이메일을 통해 사용자에게 전송되어 인증을 완료할 수 있도록 구현되었습니다.

<img width="80%" src="https://github.com/pueser/food-killer/assets/117990884/183b01f9-c0b9-4b65-bacf-a4208b4d0b44"/> 

## [검색(필터, 초성)] ##

<img width="80%" src="https://github.com/pueser/food-killer/assets/117990884/5f9f7365-a1db-491f-970e-d940850c3684"/> 

## [탈퇴] ##

<img width="80%" src="https://github.com/pueser/food-killer/assets/117990884/69324312-5995-4ce3-9ce8-d50dfc311581"/> 
