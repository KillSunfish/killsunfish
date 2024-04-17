<div align="center">
<h1>개복치 키우기 게임</h1>
<br /><br />
  
<img src="https://github.com/KillSunfish/killsunfish/assets/63188042/b9c4d2f8-ee61-4c58-87ea-456fb69a2947" alt="logo-image" width="35%"><br /><br />
JAVA Swing을 활용해 개복치 키우기 게임을 제작했습니다. <br />

</div>
<br /><br /><br />

<img src="https://github.com/KillSunfish/killsunfish/assets/63188042/7155f539-e9db-4140-8cf6-c9060e473cf8" alt="logo-image" width=35><br />
## 개복치는 이럴 때 사망해요

- 상한 먹이를 먹었을 때 → 잘못 먹어서 사망 
- 일정 시간 내에 기준치보다 많이 먹었을 때 → 과식해서 사망 
- 일정 시간 내에 기준치보다 적게 먹었을 때 → 아사로 사망 
- 사용자가 너무 많이 클릭했을 때 → 너무 만져서 사망 
- 바닷물 온도가 너무 차갑거나 뜨거울 때 → 온도 안 맞아서 사망 
- 랜덤 먹이에서 너무 맛있는 걸 먹었을 때 → 너무 맛있어서 사망
- 미니게임에서 상어에게 물렸을 때 → 상어한테 물려서 사망

<br /><br />

<img src="https://github.com/KillSunfish/killsunfish/assets/63188042/7155f539-e9db-4140-8cf6-c9060e473cf8" alt="logo-image" width=35><br />
## 사망 조건을 피해서 개복치의 몸무게를 늘려 보아요
- 과연 엔딩 화면을 보실 수 있을까요 ??!?

## 기능 소개
<h3>초기 화면</h3>
<img width="600" alt="image" src="https://github.com/KillSunfish/killsunfish/assets/70675133/cc8ced8c-58ea-4b03-b0a6-3af22490d077">

<h3>로그인 화면</h3>
<img width="600" alt="image" src="https://github.com/KillSunfish/killsunfish/assets/70675133/4b8357a2-72f5-4e32-b1db-42247a2e6a10">

<h3>메인 화면</h3>
<img width="600" alt="스크린샷 2024-04-17 오후 6 45 45" src="https://github.com/KillSunfish/killsunfish/assets/70675133/cd956bba-6408-4bef-bc13-f6499457cc1d">

<h3>온도 안 맞아서 사망</h3>
<img width="600" alt="스크린샷 2024-04-17 오후 6 46 01" src="https://github.com/KillSunfish/killsunfish/assets/70675133/4dde2074-dbc3-4740-944e-5dac84eb5e82">

<h3>잘못 먹어서 사망</h3>
<img width="600" alt="스크린샷 2024-04-17 오후 6 46 13" src="https://github.com/KillSunfish/killsunfish/assets/70675133/d3c65e1b-4277-4260-ad5d-dff23534016f">

<h3>미니 게임 화면</h3>
<img width="600" alt="스크린샷 2024-04-17 오후 6 52 18" src="https://github.com/KillSunfish/killsunfish/assets/70675133/d24330bf-f968-4518-80ae-1f07e1bc90b4">

<h3>미니 게임에서 사망</h3>
<img width="600" alt="스크린샷 2024-04-17 오후 6 47 09" src="https://github.com/KillSunfish/killsunfish/assets/70675133/fd6561cd-e43b-4fb3-b8b5-3c35b5213adf">

<h3>많이 만져서 사망</h3>
<img width="600" alt="스크린샷 2024-04-17 오후 6 46 31" src="https://github.com/KillSunfish/killsunfish/assets/70675133/c34de494-4643-4d56-8cce-42322d251bf0">

## 폴더 구조
<img width="236" alt="image" src="https://github.com/KillSunfish/killsunfish/assets/70675133/3220dc29-6e44-432a-b267-831c455f3011">

## R&R
<img width="618" alt="image" src="https://github.com/KillSunfish/killsunfish/assets/70675133/f20c1a02-38f6-4dfc-9c73-f43f20a3fc38">

## 개선 사항
<h4>객체 간 다른 객체를 참조하는 경우가 발생해 결합도 증가 </h4>
- 인터페이스의 추상화
<h4>하나의 클래스에 다양한 기능과 역할 존재 </h4>
- 코드 분리 및 모듈화
<h4>클래스 내에서 FrontController를 직접 생성</h4>
- 이는 의존성을 강하게 만들고 유연성이 떨어지기 때문에 외부에서 필요한 의존성을 주입
<h4>예외 상황에 대한 처리가 불충분 </h4>
- 예외 상황에 대한 적절한 핸들링을 추가하여 안정성 향상

## 시연 영상
https://drive.google.com/file/d/1MzIkvE2sPWZPZ_MsOgQgHoD2QcLiUFpj/view?usp=drive_link
