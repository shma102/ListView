package com.example.listview;

import java.io.File;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Environment;

public class MyApplication extends Application {

	@Override
	public void onCreate() {
		// TODO 自动生成的方法存根
		super.onCreate();
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				this)
				// max width, max height，即保存的每个缓存文件的最大长宽
				.memoryCacheExtraOptions(480, 800)
				// Can slow ImageLoader, use it carefully (Better don't use
				// it)设置缓存的详细信息，最好不要设置这个
				.discCacheExtraOptions(480, 800, CompressFormat.JPEG, 75, null)
				// 线程池内加载的数量
				.threadPoolSize(3)
				// 线程优先级
				.threadPriority(Thread.NORM_PRIORITY - 2)
				/*
				 * When you display an image in a small ImageView and later you
				 * try to display this image (from identical URI) in a larger
				 * ImageView so decoded image of bigger size will be cached in
				 * memory as a previous decoded image of smaller size. So the
				 * default behavior is to allow to cache multiple sizes of one
				 * image in memory. You can deny it by calling this method: so
				 * when some image will be cached in memory then previous cached
				 * size of this image (if it exists) will be removed from memory
				 * cache before.
				 */
				.denyCacheImageMultipleSizesInMemory()

				// You can pass your own memory cache
				// implementation你可以通过自己的内存缓存实现
				// .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 *
				// 1024))
				// .memoryCacheSize(2 * 1024 * 1024)
				// 硬盘缓存50MB
				.discCacheSize(50 * 1024 * 1024)
				// 将保存的时候的URI名称用MD5
				.discCacheFileNameGenerator(new Md5FileNameGenerator())
				// 加密
				.discCacheFileNameGenerator(new HashCodeFileNameGenerator())
				// 将保存的时候的URI名称用HASHCODE加密
				.tasksProcessingOrder(QueueProcessingType.LIFO)
				.discCacheFileCount(100)
				// 缓存的File数量
				.discCache(
						new UnlimitedDiscCache(new File(Environment
								.getExternalStorageDirectory()
								+ "myApp/imageCache")))
				// 自定义缓存路径
				.defaultDisplayImageOptions(DisplayImageOptions.createSimple())
				.imageDownloader(
						new BaseImageDownloader(this, 5 * 1000, 30 * 1000)) // connectTimeout
				.writeDebugLogs() // Remove for release app
				.build();
		ImageLoader.getInstance().init(config);// 全局初始化此配置  
		
	}

	public DisplayImageOptions getDisplayOptions() {
		DisplayImageOptions options = new DisplayImageOptions.Builder()
		// 设置图片在下载期间显示的图片
				.showImageOnLoading(R.drawable.ic_launcher)
				// 设置图片Uri为空或是错误的时候显示的图片
				.showImageForEmptyUri(R.drawable.ic_launcher)
				// 设置图片加载/解码过程中错误时候显示的图片
				.showImageOnFail(R.drawable.ic_launcher)
				// 设置下载的图片是否缓存在内存中
				.cacheInMemory(true)
				// 设置下载的图片是否缓存在SD卡中
				.cacheOnDisc(true)
				// 保留Exif信息
				.considerExifParams(true)
				// 设置图片以如何的编码方式显示
				.imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
				// 设置图片的解码类型
				.bitmapConfig(Bitmap.Config.RGB_565)
				// .decodingOptions(android.graphics.BitmapFactory.Options
				// decodingOptions)//设置图片的解码配置
				// .considerExifParams(true)
				// 设置图片下载前的延迟
				// .delayBeforeLoading(100)// int
				// delayInMillis为你设置的延迟时间
				// 设置图片加入缓存前，对bitmap进行设置
				// .preProcessor(BitmapProcessor preProcessor)
				.resetViewBeforeLoading(true)// 设置图片在下载前是否重置，复位
				.displayer(new RoundedBitmapDisplayer(20))// 是否设置为圆角，弧度为多少
				.displayer(new FadeInBitmapDisplayer(100))// 淡入
				.build();
		return options;
	}
}
