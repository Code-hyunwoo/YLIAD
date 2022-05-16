import styles from "./Intro.module.css";
import moon from "../assets/images/moon.png";
import apk from "../assets/images/downloadapk.png";
import moving from "../assets/images/movingad.gif";
import read from "../assets/images/read.png";
import { toast, ToastContainer } from "react-toastify";
import { stepButtonClasses } from "@mui/material";

function Intro() {
  function subscribe() {
    toast.success("구독 신청이 완료되었습니다!", {
      position: "top-right",
      autoClose: 2500,
      hideProgressBar: false,
      closeOnClick: true,
      pauseOnHover: false,
      draggable: true,
    });
  }
  return (
    <>
      <section className={styles.section1}>
        <div className={styles.wrapper_intro}>
          <ToastContainer />
          {/* 네비게이션 바 */}
          <div className={styles.navbar}>
            <div className={styles.icon}>
              <img src={moon} alt="moon" />
              YLIAD
            </div>
            <ul className={styles.menu}>
              <li>FEATURES</li>
              <li>ABOUT US</li>
            </ul>
          </div>
          {/* 서비스 소개 - 제목 */}

          <div className={styles.header}>
            <p>
              AI Voice Diary App for Web, Android
              <br />
            </p>
            <span>
              인공지능 음성 다이어리 YLIAD로 하루를 아름답게 마무리하세요!
            </span>
          </div>
          {/* 서비스 다운로드 / 구독 */}
          <div className={styles.downsubs}>
            <img src={apk} alt="apkLink" />
            <div className={styles.subscribe}>
              <input type="text" placeholder="Your Email Address" />
              <button onClick={subscribe}>Subscribe</button>
              <p>
                구독하시면 YLIAD의 최신 업데이트 내용, 이벤트 등의 소식을
                누구보다 빨리 받아보실 수 있습니다.
              </p>
            </div>
          </div>
          <img src={moving} alt="movingad" id={styles.movingAd} />
        </div>
      </section>

      <section className={styles.section2}>
        <div className={styles.wrapper_body}>
          <div className={styles.feature1}>
            <img src={read} alt="YLIAD1" />
            <p>YLIAD는 인공지능입니다.</p>
            <span>
              인공지능 챗봇을 통해 힘든 마음을 치유할 수 있고,
              <br />
              감정분석도 해줍니다.
            </span>
          </div>
          <div className={styles.feature2}>
            <img src={read} alt="YLIAD2" />
            <p>YLIAD는 인공지능입니다.</p>
            <span>
              감정쓰레기통에서는
              <br />
              잊고 싶은 오늘의 기억을 버려두고 가세요.
            </span>
          </div>
        </div>
      </section>
    </>
  );
}

export default Intro;
