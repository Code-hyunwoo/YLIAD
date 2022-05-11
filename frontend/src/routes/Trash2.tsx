import { BrowserView, MobileView } from "react-device-detect";
import { Link } from "react-router-dom";
import Navbar from "../components/layout/Navbar";
import Stars2 from "../components/layout/Stars2";
import base from "./Base.module.css";
import styles from "./Trash2.module.css";

function Trash2() {
  return (
    <>
      <Navbar />
      <BrowserView>
        <div className={base.container}>
          <div className={styles.backP}></div>
          <div className={styles.lightP}></div>
          <div className={styles.contentP}>
            <div className={styles.fireP}>
              <div className={styles.bottomP}></div>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
            </div>
            <div className={styles.reverseP}>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
            </div>
          </div>
          <p>
            지우고 싶은 기억을 입력하고 불태우세요..
            <br />
            <textarea />
            <button>불태워 지우기</button>
            <span className={styles.authorP}>Burn it</span>
            <Link to="/lobby">
              <button> 로비로 이동 </button>
            </Link>
          </p>
          <svg xmlns="http://www.w3.org/2000/svg" version="1.1">
            <defs>
              <filter id="goo">
                <feGaussianBlur
                  in="SourceGraphic"
                  stdDeviation="10"
                  result="blur"
                />
                <feColorMatrix
                  in="blur"
                  mode="matrix"
                  values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 18 -7"
                  result="goo"
                />
                <feBlend in="SourceGraphic" in2="goo" />
              </filter>
            </defs>
          </svg>
        </div>
      </BrowserView>

      <MobileView>
        <div className={base.container}>
          <div className={styles.back}></div>
          <div className={styles.light}></div>
          <div className={styles.content}>
            <div className={styles.fire}>
              <div className={styles.bottom}></div>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
            </div>
            <div className={styles.reverse}>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
            </div>
          </div>
          <p>
            지우고 싶은 기억을 입력하고 불태우세요..
            <br />
            <textarea />
            <button>불태워 지우기</button>
            <span className={styles.author}>Burn it</span>
            <Link to="/lobby">
              <button> 로비로 이동 </button>
            </Link>
          </p>
          <svg xmlns="http://www.w3.org/2000/svg" version="1.1">
            <defs>
              <filter id="goo">
                <feGaussianBlur
                  in="SourceGraphic"
                  stdDeviation="10"
                  result="blur"
                />
                <feColorMatrix
                  in="blur"
                  mode="matrix"
                  values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 18 -7"
                  result="goo"
                />
                <feBlend in="SourceGraphic" in2="goo" />
              </filter>
            </defs>
          </svg>
        </div>
      </MobileView>
    </>
  );
}

export default Trash2;
