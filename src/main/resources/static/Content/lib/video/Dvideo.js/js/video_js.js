
// window.onload = function () {
var videoWrap = document.getElementById('testVideo')
var fullScreen = document.getElementById('getFullScreen')
var video = new Dvideo ({
    ele: '#testVideo',
    title: 'Pneumatic Tokyo - EnV',
    nextVideoExtend: function () {
        alert('您点击了下一页')
    },
    showNext: true,
    width: '580px',
    height: '292px',
    /*路径*/
    src: 'http://oxyi0vk1f.bkt.clouddn.com/evn4.mp4',

    autoplay: true,
    setVideoDefinition: function (type, e, current) {
        if (type === '0') {
            alert('你点击了标清')
            // video.setVideoInfo('這是標清','这里填写视频的标清地址',current)
        }
        if (type === '1') {
            alert('你点击了标清')
            // video.setVideoInfo('這是標清','这里填写视频的高清地址',current)
        }
        if (type === '2') {
            alert('你点击了标清')
            // video.setVideoInfo('這是標清','这里填写视频的超清地址',current)
        }
        video.showLoading(false)

        // setTimeout(function () {
        // 	video.videoEle.currentTime = current
        // 	video.videoPlay()
        // 	video.showLoading(false)
        // }, 3000)
    },
})

// 全屏
function setFullScreen () {
    video.launchFullScreen(videoWrap)
}

// 播放
function play () {
    video.videoPlay()
}

// 暂停
function pause () {
    video.videoPause()
}

// 播放暂停
function playpause () {
    video.videoPlayPause()
}

function setVolume (v) {
    video.updateVolume(v)
}

function setBackRate (index) {
    video.setPlayBackRate(index)
}

function setVideoForward () {
    video.videoForward(10)
}

function setVideoRewind () {
    video.videoRewind(10)
}

function showLoading () {
    video.showLoading(true, '视频清晰度切换中，请稍等')
}

function showTopBottomCtrlNotClose () {
    video.showTopBottomCtrl()
}

function hideTopBottomCtrlLi () {
    video.hideTopBottomCtrl(true)
}

function showTopBottomCtrl () {
    video.showTopBottomCtrl(true)
}

function hideTopBottomCtrl () {
    video.hideTopBottomCtrl()
}

function setVideoSize () {
    video.updateVideoSize(720,480)
}
