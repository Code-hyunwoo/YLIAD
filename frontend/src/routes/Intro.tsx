import styles from "./Intro.module.css";
import moon from "../assets/images/moon.png";
import apk from "../assets/images/downloadapk.png";
import moving from "../assets/images/movingad.gif";

function Intro() {
  return (
    <div className={styles.wrapper}>
      {/* Navbar */}
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
      </div>
      <img src={moving} alt="movingad" id={styles.movingAd} />
    </div>
  );
}

export default Intro;
